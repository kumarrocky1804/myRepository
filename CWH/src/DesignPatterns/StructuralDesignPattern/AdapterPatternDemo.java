package DesignPatterns.StructuralDesignPattern;

/* Adapter pattern is used as bridge between two incompatible interfaces
 * 
 * below example is an media player example that plays MP3 music but uses adapters to play 
 * VLC music
 * 
 * Structural Design Pattern
 */
// an advance media player
interface AdvanceMediaPlayer
{
	public void playVLC();
}

class VLCPlayer implements AdvanceMediaPlayer
{
	@Override
	public void playVLC() {
		System.out.println("Playing VLC through VLC player");
	}
}

// an ordinary Media player that can play MP3 music only
interface MediaPlayer
{
	public void playMusic(String type);
}

// adapter for connecting Media player to Advance Media Player
class MediaPlayerAdapter implements MediaPlayer
{
	AdvanceMediaPlayer amp;
	
	public MediaPlayerAdapter(AdvanceMediaPlayer amp)
	{
		this.amp = amp;
	}
	
	@Override
	public void playMusic(String type)
	{
		if("vlc".equalsIgnoreCase(type))
			amp.playVLC();
		else
			throw new IllegalArgumentException("Audio format not supported - " + type);
	}
}

//concrete class for normal Media player
class AudioPlayer implements MediaPlayer
{
	@Override
	public void playMusic(String type)
	{
		// this player can play MP3 music
		if("mp3".equalsIgnoreCase(type))
			System.out.println("Playing MP3 in normal media player");
		// for other formats, it uses the adapters
		else
		{
			MediaPlayerAdapter adapter = new MediaPlayerAdapter(new VLCPlayer());
			adapter.playMusic(type);
		}
	}
}

public class AdapterPatternDemo {

	public static void main(String[] args) 
	{
		AudioPlayer player = new AudioPlayer();
		
		player.playMusic("mp3");
		player.playMusic("vlc");
		player.playMusic("mp4");
	}

}
