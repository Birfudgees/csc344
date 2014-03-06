/**
 * CSC 344, Project 4: Algorithmic Composition
 * Kyle Schaefer
 *
 * This program writes a short solo piano piece in D 
 * harmonic minor and then exports it as a midi file.
 *
 * Incorporates Karl Browns' program for building a midi file.
 */

import java.io.*;
import java.util.*;
import javax.sound.midi.*; 
public class midifile
{
  public static void main(String argv[]) {
    System.out.println("midifile begin ");
	try
	{
   int tick = 1;
   int basstick =1;
   int randomnum;
   int randomtick;
   int bass;
   int randomnote;
   int randombass;   
   
   Random rand = new Random();
   
   
//****  Create a new MIDI sequence with 24 ticks per beat  ****
		Sequence s = new Sequence(javax.sound.midi.Sequence.PPQ,24);

//****  Obtain a MIDI track from the sequence  ****
		Track t = s.createTrack();

//****  General MIDI sysex -- turn on General MIDI sound set  ****
		byte[] b = {(byte)0xF0, 0x7E, 0x7F, 0x09, 0x01, (byte)0xF7};
		SysexMessage sm = new SysexMessage();
		sm.setMessage(b, 6);
		MidiEvent me = new MidiEvent(sm,(long)0);
		t.add(me);

//****  set tempo (meta event)  ****
		MetaMessage mt = new MetaMessage();
        byte[] bt = {0x02, (byte)0x00, 0x00};
		mt.setMessage(0x51 ,bt, 3);
		me = new MidiEvent(mt,(long)0);
		t.add(me);

//****  set track name (meta event)  ****
		mt = new MetaMessage();
		String TrackName = new String("midifile track");
		mt.setMessage(0x03 ,TrackName.getBytes(), TrackName.length());
		me = new MidiEvent(mt,(long)0);
		t.add(me);

//****  set omni on  ****
		ShortMessage mm = new ShortMessage();
		mm.setMessage(0xB0, 0x7D,0x00);
		me = new MidiEvent(mm,(long)0);
		t.add(me);

//****  set poly on  ****
		mm = new ShortMessage();
		mm.setMessage(0xB0, 0x7F,0x00);
		me = new MidiEvent(mm,(long)0);
		t.add(me);

//****  set instrument to Piano  ****
		mm = new ShortMessage();
		mm.setMessage(0xC0, 0x00, 0x00);
		me = new MidiEvent(mm,(long)0);
		t.add(me);


// Generate a random 96-bar melody, with the notes
// restricted to a 1-octave range of the D harmonic 
// minor scale.  

while (tick < 9216) {

randomnum = rand.nextInt(8 - (1 - 1)) + 1;
randomtick = rand.nextInt(3 - (1 - 1)) + 1;
randomtick = randomtick * 24;

 if(randomnum == 1){
 randomnote = 50;
 }
 else if(randomnum == 2){
 randomnote = 52;
 }
 else if(randomnum == 3){
 randomnote = 53;
 }
 else if(randomnum == 4){
 randomnote = 55;
 }
 else if(randomnum == 5){
 randomnote = 57;
 }
 else if(randomnum == 6){
 randomnote = 58;
 }
 else if(randomnum == 7){
 randomnote = 61;
 }
 else {
 randomnote = 62;
 }
    
// Generate the random notes, with random 
// lengths of either 1, 2 or 3 beats in 
// order to create random rhythms.

		mm = new ShortMessage();
		mm.setMessage(0x90,randomnote,0x60);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
      tick+=randomtick;

		mm = new ShortMessage();
		mm.setMessage(0x80,randomnote,0x40);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);

}

// Start generating an accompanying bassline.
// The first 2 bars are not randomized - they 
// are set to play the root note, D, because 
// I want my piece to start on the "1" chord.

mm = new ShortMessage();
		mm.setMessage(0x90,38,0x60);
		me = new MidiEvent(mm,(long)basstick);
		t.add(me);

basstick+=192;

		mm = new ShortMessage();
		mm.setMessage(0x80,38,0x40);
		me = new MidiEvent(mm,(long)basstick);
		t.add(me);

// Generate the rest of the bassline
while (basstick < 9216) {

// Restrict the bassline notes to only 4 notes of the 
// harmonic minor scale - scale degrees 1, 4, 5 and 6,
// in order to retain a somewhat structured sense
// of harmonic progression.

randombass = rand.nextInt(4 - (1 - 1)) + 1;

if(randombass == 1){
 bass = 38;
 }
 else if(randombass == 2){
 bass = 46;
 }
 else if(randombass == 3){
 bass = 43;
 }
 else{
 bass = 45;
 }
 
 // Generate the bass notes.  The bass rhythms are not
 // randomized, they are set to change every 2 bars, 
 // on beat 1 each time, in order to hold down the 
 // much less structured melody line.  
 
 mm = new ShortMessage();
		mm.setMessage(0x90,bass,0x60);
		me = new MidiEvent(mm,(long)basstick);
		t.add(me);
      
      basstick+=192;

		mm = new ShortMessage();
		mm.setMessage(0x80,bass,0x40);
		me = new MidiEvent(mm,(long)basstick);
		t.add(me);

}

// After 96 bars of random music, play a "D"
// note in both voices to bring resolution
// to the piece.

mm = new ShortMessage();
		mm.setMessage(0x90,38,0x60);
		me = new MidiEvent(mm,(long)9216);
		t.add(me);

		mm = new ShortMessage();
		mm.setMessage(0x80,38,0x40);
		me = new MidiEvent(mm,(long)9312);
		t.add(me);

mm = new ShortMessage();
		mm.setMessage(0x90,62,0x60);
		me = new MidiEvent(mm,(long)9216);
		t.add(me);

		mm = new ShortMessage();
		mm.setMessage(0x80,62,0x40);
		me = new MidiEvent(mm,(long)9312);
		t.add(me);


//****  set end of track (meta event) 19 ticks later  ****
		mt = new MetaMessage();
        byte[] bet = {}; // empty array
		mt.setMessage(0x2F,bet,0);
		me = new MidiEvent(mt, (long)140);
		t.add(me);

//****  write the MIDI sequence to a MIDI file  ****
		File f = new File("midifile.mid");
		MidiSystem.write(s,1,f);
	} //try
		catch(Exception e)
	{
		System.out.println("Exception caught " + e.toString());
	} //catch
    System.out.println("midifile end ");
  } //main
} //midifile
