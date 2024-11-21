/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.sound.sampled;

import gnu.testlet.ResourceNotFoundException;
import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioProperties
implements Testlet {
    private static final String BASE_PATH = "gnu#testlet#javax#sound#sampled#data#";
    private static final String WAV = "gnu#testlet#javax#sound#sampled#data#k3b_success1.wav";
    private static final String AU = "gnu#testlet#javax#sound#sampled#data#k3b_success1.au";
    protected TestHarness harness = null;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.testWav();
        this.testAU();
    }

    private void processWaveStream(AudioInputStream stream) {
        AudioFormat format2 = stream.getFormat();
        this.harness.check(format2.getFrameSize() == 1);
        this.harness.check(format2.getChannels() == 1);
        this.harness.check((double)format2.getSampleRate() == 8000.0);
        this.harness.check((double)format2.getFrameRate() == 8000.0);
        this.harness.check(format2.getSampleSizeInBits() == 8);
    }

    private void processAUStream(AudioInputStream stream) {
        AudioFormat format2 = stream.getFormat();
        this.harness.check(format2.getFrameSize() == 2);
        this.harness.check(format2.getChannels() == 1);
        this.harness.check((double)format2.getSampleRate() == 8000.0);
        this.harness.check((double)format2.getFrameRate() == 8000.0);
        this.harness.check(format2.getSampleSizeInBits() == 16);
    }

    private AudioInputStream getAudioStream(String filepath, boolean stream) throws IOException, UnsupportedAudioFileException {
        File file = null;
        try {
            file = this.harness.getResourceFile(filepath);
        }
        catch (ResourceNotFoundException e1) {
            throw new IOException("ResourceNotFoundException: check the correct input file location");
        }
        AudioInputStream audioInputStream = null;
        audioInputStream = stream ? AudioSystem.getAudioInputStream(new FileInputStream(file)) : AudioSystem.getAudioInputStream(file);
        return audioInputStream;
    }

    private void testWav() {
        this.harness.checkPoint("testWav()");
        try {
            this.harness.checkPoint("testWav() - FILE");
            AudioInputStream audioInputStream = this.getAudioStream(WAV, false);
            this.processWaveStream(audioInputStream);
            this.harness.checkPoint("testWav() - STREAM");
            AudioInputStream audioInputStream2 = this.getAudioStream(WAV, true);
            this.processWaveStream(audioInputStream2);
        }
        catch (UnsupportedAudioFileException e) {
            this.harness.fail("Wave files should be supported by any implementation");
        }
        catch (IOException e) {
            this.harness.fail(e.getMessage());
        }
    }

    private void testAU() {
        this.harness.checkPoint("testAU()");
        try {
            this.harness.checkPoint("testAU() - FILE");
            AudioInputStream audioInputStream = this.getAudioStream(AU, false);
            this.processAUStream(audioInputStream);
            this.harness.checkPoint("testAU() - STREAM");
            AudioInputStream audioInputStream2 = this.getAudioStream(AU, true);
            this.processAUStream(audioInputStream2);
        }
        catch (UnsupportedAudioFileException e) {
            this.harness.fail("AU files should be supported by any implementation");
        }
        catch (IOException e) {
            this.harness.fail(e.getMessage());
        }
    }
}

