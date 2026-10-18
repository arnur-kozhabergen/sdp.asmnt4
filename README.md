# Assignment 4 — Facade Pattern

Student: Arnur Kozhabergen  
Group: se-2529  
Topic: Media conversion

## Run

Use JDK 17 or newer:

    javac --release 17 -encoding UTF-8 -d out "@sources.txt"
    java -cp out Main

## Design

Main uses only MediaConversionFacade. The facade calls MetadataReader, CodecFactory, BitrateReader, and AudioMixer in order.

The example uses simulated audio samples. BitrateReader reduces or duplicates samples to model a bitrate change. AudioMixer combines each stereo pair into one mono sample. No media files or external libraries are needed.