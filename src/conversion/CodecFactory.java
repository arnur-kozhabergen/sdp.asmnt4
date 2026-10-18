package conversion;

public class CodecFactory {
    public String createCodec(String sourceFormat, String targetFormat) {
        if (!isSupported(sourceFormat) || !isSupported(targetFormat)) {
            throw new IllegalArgumentException("Only mp3 and wav formats are supported");
        }

        if (sourceFormat.equals(targetFormat)) {
            return targetFormat.toUpperCase() + " codec";
        }

        return sourceFormat.toUpperCase() + " decoder + "
                + targetFormat.toUpperCase() + " encoder";
    }

    private boolean isSupported(String format) {
        return "mp3".equals(format) || "wav".equals(format);
    }
}