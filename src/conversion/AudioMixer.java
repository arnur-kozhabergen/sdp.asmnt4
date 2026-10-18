package conversion;

public class AudioMixer {
    public int[] mixToMono(int[] stereoSamples) {
        if (stereoSamples == null) {
            throw new IllegalArgumentException("Stereo samples are required");
        }

        if (stereoSamples.length % 2 != 0) {
            throw new IllegalArgumentException("Stereo samples must come in pairs");
        }

        int[] monoSamples = new int[stereoSamples.length / 2];

        for (int i = 0; i < stereoSamples.length; i += 2) {
            monoSamples[i / 2] = (stereoSamples[i] + stereoSamples[i + 1]) / 2;
        }

        return monoSamples;
    }
}