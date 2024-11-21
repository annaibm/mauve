/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ImageReaderWriterSpi;

import java.util.Locale;
import javax.imageio.spi.ImageReaderWriterSpi;

class TestProvider
extends ImageReaderWriterSpi {
    public static final String VENDOR_NAME = "Free Software Foundation, Inc.";
    public static final String VERSION = "1.0";
    public static final String[] NAMES = new String[]{"Tagged Image File Format"};
    public static final String[] SUFFIXES = new String[]{"tiff", "tif"};
    public static final String[] MIME_TYPES = new String[]{"image/tiff"};
    public static final String PLUGIN_CLASS_NAME = "gnu.javax.imageio.plugin.tiff.Reader";
    public static final String NATIVE_STREAM_METADATA_FORMAT_NAME = "TIFF File Metadata";
    public static final String NATIVE_STREAM_METADATA_FORMAT_CLASS_NAME = "gnu.javax.imageio.plugin.tiff.StreamMetadata";
    public static final String[] EXTRA_STREAM_METADATA_FORMAT_NAMES = new String[]{"Stream Metadata"};
    public static final String[] EXTRA_STREAM_METADATA_FORMAT_CLASS_NAMES = new String[]{"gnu.javax.imageio.plugin.tiff.StreamMetadata"};
    public static final String NATIVE_IMAGE_METADATA_FORMAT_NAME = "TIFF Image Metadata";
    public static final String NATIVE_IMAGE_METADATA_FORMAT_CLASS_NAME = "gnu.javax.imageio.plugin.tiff.ImageMetadata";
    public static final String[] EXTRA_IMAGE_METADATA_FORMAT_NAMES = new String[]{"GeoTIFF"};
    public static final String[] EXTRA_IMAGE_METADATA_FORMAT_CLASS_NAMES = new String[]{"gnu.javax.imageio.plugin.tiff.GeoTIFFMetadata"};

    private TestProvider(boolean b) {
        super(VENDOR_NAME, VERSION, NAMES, SUFFIXES, MIME_TYPES, PLUGIN_CLASS_NAME, true, NATIVE_STREAM_METADATA_FORMAT_NAME, NATIVE_STREAM_METADATA_FORMAT_CLASS_NAME, EXTRA_STREAM_METADATA_FORMAT_NAMES, EXTRA_STREAM_METADATA_FORMAT_CLASS_NAMES, true, NATIVE_IMAGE_METADATA_FORMAT_NAME, NATIVE_IMAGE_METADATA_FORMAT_CLASS_NAME, EXTRA_IMAGE_METADATA_FORMAT_NAMES, EXTRA_IMAGE_METADATA_FORMAT_CLASS_NAMES);
    }

    public static TestProvider createProvider() {
        return new TestProvider(true);
    }

    public TestProvider() {
    }

    @Override
    public String getDescription(Locale locale) {
        return "desc";
    }
}

