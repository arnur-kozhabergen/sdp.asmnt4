package conversion;

public class BitrateReader {
    public int[] changeBitrate(int[] samples, String sourceFormat, String targetFormat) {
        if (samples == null) {
            throw new IllegalArgumentException("Samples are required");
        }

        if (samples.length % 2 != 0) {
            throw new IllegalArgumentException("Stereo samples must come in pairs");
        }

        int sourceBitrate = bitrateFor(sourceFormat);
        int targetBitrate = bitrateFor(targetFormat);
        int frameCount = samples.length / 2;

        if (sourceBitrate > targetBitrate) {
            int outputFrames = (frameCount + 1) / 2;
            int[] smallerSamples = new int[outputFrames * 2];

            for (int frame = 0; frame < frameCount; frame += 2) {
                int sourceIndex = frame * 2;
                int targetIndex = (frame / 2) * 2;
                smallerSamples[targetIndex] = samples[sourceIndex];
                smallerSamples[targetIndex + 1] = samples[sourceIndex + 1];
            }

            return smallerSamples;
        }

        if (sourceBitrate < targetBitrate) {
            int[] largerSamples = new int[samples.length * 2];

            for (int frame = 0; frame < frameCount; frame++) {
                int sourceIndex = frame * 2;
                int targetIndex = frame * 4;
                largerSamples[targetIndex] = samples[sourceIndex];
                largerSamples[targetIndex + 1] = samples[sourceIndex + 1];
                largerSamples[targetIndex + 2] = samples[sourceIndex];
                largerSamples[targetIndex + 3] = samples[sourceIndex + 1];
            }

            return largerSamples;
        }

        return samples.clone();
    }

    private int bitrateFor(String format) {
        if ("mp3".equals(format)) {
            return 320;
        }

        if ("wav".equals(format)) {
            return 1411;
        }

        throw new IllegalArgumentException("Only mp3 and wav formats are supported");
    }
}