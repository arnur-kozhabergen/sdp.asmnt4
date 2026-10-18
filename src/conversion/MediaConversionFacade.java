package conversion;

import java.util.Arrays;
import java.util.Locale;

public class MediaConversionFacade {
    private final MetadataReader metadataReader = new MetadataReader();
    private final CodecFactory codecFactory = new CodecFactory();
    private final BitrateReader bitrateReader = new BitrateReader();
    private final AudioMixer audioMixer = new AudioMixer();

    public String convert(String fileName, String targetFormat) {
        String sourceFormat = metadataReader.readFormat(fileName);
        String normalizedTarget = targetFormat == null
                ? ""
                : targetFormat.trim().toLowerCase(Locale.ROOT);

        String codec = codecFactory.createCodec(sourceFormat, normalizedTarget);
        int[] sampleData = {10, 30, 20, 40, 30, 50, 40, 60};
        int[] adjustedSamples = bitrateReader.changeBitrate(
                sampleData, sourceFormat, normalizedTarget);
        int[] monoSamples = audioMixer.mixToMono(adjustedSamples);
        String outputName = fileName.substring(0, fileName.lastIndexOf('.') + 1)
                + normalizedTarget;

        return "File: " + fileName + " -> " + outputName
                + "\nCodec: " + codec
                + "\nMono samples: " + Arrays.toString(monoSamples);
    }
}