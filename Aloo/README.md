# Aloovoice

Local, root-assisted voicemail for Android 11.

## Target behavior
- Incoming cellular call rings normally.
- If still ringing after 20 seconds, Aloovoice attempts to answer locally.
- Plays a locally stored greeting where supported by the device/ROM audio path.
- Records the voicemail locally where call-audio capture is supported.
- Stores caller metadata, timestamp, duration, and recording locally.
- No cloud voicemail service.

## Development status
Initial scaffold. Android 11 / rooted-device compatibility is the primary target.

> Note: Cellular call answering, call-audio capture, and uplink audio injection are device/ROM dependent even with root. Aloovoice must detect capabilities rather than pretending unsupported routing works.
