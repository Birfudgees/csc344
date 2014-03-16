/**
 * CSC 344, Final Project: Guitar Solo Generator
 * Kyle Schaefer
 *
 * This program writes a set of three guitar solos to go over 
 * pre-made backing tracks and exports them all as a midi file.
 *
 * Solo #1 - Blues in E Major
 * Solo #2 - Pop/rock in A Major
 * Solo #3 - Metal in A Minor
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
   int randomnum;
   int randomtick;
   int randomnote;
   int randomrhythm;  
   
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







// ************** PART 1 ********************
// Random notes will be generated from the E major pentatonic scale (with the added
// chromatic "blue" note).  Rhythms will be randomly selected from 3 predefined, 1-beat long 
// rhythms: a quarter note, a set of 3 eighth note triplets, and 2 eigth notes with a "swung"
// feel.  

tick = 145;

// set time frame to match with the first backing track
while (tick > 144 && tick < 1873) {

randomnum = rand.nextInt(7 - (1 - 1)) + 1;
randomtick = rand.nextInt(3 - (1 - 1)) + 1;

 if(randomnum == 1){
 randomnote = 76;
 }
 else if(randomnum == 2){
 randomnote = 64;
 }
 else if(randomnum == 3){
 randomnote = 66;
 }
 else if(randomnum == 4){
 randomnote = 67;
 }
 else if(randomnum == 5){
 randomnote = 68;
 }
 else if(randomnum == 6){
 randomnote = 71;
 }
 else {
 randomnote = 73;
 }
    
// Rhythm #1 - 3 eighth note triplets
if(randomtick == 1){

		mm = new ShortMessage();
		mm.setMessage(0x90,randomnote,0x60);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
      tick+=12;

		mm = new ShortMessage();
		mm.setMessage(0x80,randomnote,0x40);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
randomnum = rand.nextInt(7 - (1 - 1)) + 1;
 if(randomnum == 1){
 randomnote = 76;
 }
 else if(randomnum == 2){
 randomnote = 64;
 }
 else if(randomnum == 3){
 randomnote = 66;
 }
 else if(randomnum == 4){
 randomnote = 67;
 }
 else if(randomnum == 5){
 randomnote = 68;
 }
 else if(randomnum == 6){
 randomnote = 71;
 }
 else {
 randomnote = 73;
 }
      
      	mm = new ShortMessage();
		mm.setMessage(0x90,randomnote,0x60);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
      tick+=12;

		mm = new ShortMessage();
		mm.setMessage(0x80,randomnote,0x40);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
randomnum = rand.nextInt(7 - (1 - 1)) + 1;
 if(randomnum == 1){
 randomnote = 76;
 }
 else if(randomnum == 2){
 randomnote = 64;
 }
 else if(randomnum == 3){
 randomnote = 66;
 }
 else if(randomnum == 4){
 randomnote = 67;
 }
 else if(randomnum == 5){
 randomnote = 68;
 }
 else if(randomnum == 6){
 randomnote = 71;
 }
 else {
 randomnote = 73;
 }

	mm = new ShortMessage();
		mm.setMessage(0x90,randomnote,0x60);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
      tick+=12;

		mm = new ShortMessage();
		mm.setMessage(0x80,randomnote,0x40);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
}

// Rhythm #2 - 2 swung eighth notes
else if(randomtick == 2){

		mm = new ShortMessage();
		mm.setMessage(0x90,randomnote,0x60);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
      tick+=24;

		mm = new ShortMessage();
		mm.setMessage(0x80,randomnote,0x40);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
randomnum = rand.nextInt(7 - (1 - 1)) + 1;
 if(randomnum == 1){
 randomnote = 76;
 }
 else if(randomnum == 2){
 randomnote = 64;
 }
 else if(randomnum == 3){
 randomnote = 66;
 }
 else if(randomnum == 4){
 randomnote = 67;
 }
 else if(randomnum == 5){
 randomnote = 68;
 }
 else if(randomnum == 6){
 randomnote = 71;
 }
 else {
 randomnote = 73;
 }
      
      	mm = new ShortMessage();
		mm.setMessage(0x90,randomnote,0x60);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
      tick+=12;

		mm = new ShortMessage();
		mm.setMessage(0x80,randomnote,0x40);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
	}

//Rhythm #3 - quarter note
else if(randomtick == 3){

		mm = new ShortMessage();
		mm.setMessage(0x90,randomnote,0x60);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
      tick+=36;

		mm = new ShortMessage();
		mm.setMessage(0x80,randomnote,0x40);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
      	}
}

//play an "E" note at the end of solo #1
mm = new ShortMessage();
		mm.setMessage(0x90,64,0x60);
		me = new MidiEvent(mm,(long)1873);
		t.add(me);

		mm = new ShortMessage();
		mm.setMessage(0x80,64,0x40);
		me = new MidiEvent(mm,(long)1897);
		t.add(me);
      
      
      
      
      
      
      
//***************** PART 2 **************************
// Random notes will be generated from one octave of the A-major scale,
// with random rhythms built from eighth notes, quarter notes and 
// dotted quarter notes.  This is the simplest of the 3 solos.
      
tick = 2305;
      
// set time frame to match with the second backing track      
while (tick > 2304 && tick < 3841) {

randomnum = rand.nextInt(8 - (1 - 1)) + 1;
randomtick = rand.nextInt(3 - (1 - 1)) + 1;
randomtick = randomtick * 24;

 if(randomnum == 1){
 randomnote = 69;
 }
 else if(randomnum == 2){
 randomnote = 71;
 }
 else if(randomnum == 3){
 randomnote = 73;
 }
 else if(randomnum == 4){
 randomnote = 74;
 }
 else if(randomnum == 5){
 randomnote = 76;
 }
 else if(randomnum == 6){
 randomnote = 78;
 }
 else if(randomnum == 7){
 randomnote = 80;
 }
 else {
 randomnote = 81;
 }
    
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

// play an "A" note at the end of solo #2
mm = new ShortMessage();
		mm.setMessage(0x90,69,0x60);
		me = new MidiEvent(mm,(long)3841);
		t.add(me);

		mm = new ShortMessage();
		mm.setMessage(0x80,69,0x40);
		me = new MidiEvent(mm,(long)3865);
		t.add(me);









//**************************** PART 3 *************************
// Generates a fast, crazy metal solo with notes that are dependent on 
// whatever chord is currently being played. The chord progression is 
// in A minor, but with a few chromatic chords/notes thrown in for good
// measure: Am, Ddim, Fmaj, Emaj.  The rhythms are a random combination of 
// sixteenths notes and eighth notes, but weighted towards the sixteenths
// with a 2:1 probability.


tick = 4225;

// chord #1: 8 beats on A minor
while (tick > 4224 && tick < 4417) {

randomnum = rand.nextInt(6 - (1 - 1)) + 1;
randomtick = rand.nextInt(6 - (1 - 1)) + 1;

 if(randomnum == 1){
 randomnote = 57;
 }
 else if(randomnum == 2){
 randomnote = 60;
 }
 else if(randomnum == 3){
 randomnote = 64;
 }
 else if(randomnum == 4){
 randomnote = 69;
 }
 else if(randomnum == 5){
 randomnote = 72;
 }
 else {
 randomnote = 76;
 }
 
 if(randomtick == 1){
 randomrhythm = 6;
 }
 else if(randomtick == 2){
 randomrhythm = 6;
 }
 else if(randomtick == 3){
 randomrhythm = 6;
 }
 else if(randomtick == 4){
 randomrhythm = 6;
 }
 else if(randomtick == 5){
 randomrhythm = 12;
 }
 else {
 randomrhythm = 12;
 }

		mm = new ShortMessage();
		mm.setMessage(0x90,randomnote,0x60);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
      tick+=randomrhythm;

		mm = new ShortMessage();
		mm.setMessage(0x80,randomnote,0x40);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);

}

// chord #2: 8 beats on D diminished
while (tick > 4416 && tick < 4609) {

randomnum = rand.nextInt(6 - (1 - 1)) + 1;
randomtick = rand.nextInt(6 - (1 - 1)) + 1;

 if(randomnum == 1){
 randomnote = 59;
 }
 else if(randomnum == 2){
 randomnote = 62;
 }
 else if(randomnum == 3){
 randomnote = 65;
 }
 else if(randomnum == 4){
 randomnote = 68;
 }
 else if(randomnum == 5){
 randomnote = 71;
 }
 else {
 randomnote = 74;
 }
 
 if(randomtick == 1){
 randomrhythm = 6;
 }
 else if(randomtick == 2){
 randomrhythm = 6;
 }
 else if(randomtick == 3){
 randomrhythm = 6;
 }
 else if(randomtick == 4){
 randomrhythm = 6;
 }
 else if(randomtick == 5){
 randomrhythm = 12;
 }
 else {
 randomrhythm = 12;
 }

		mm = new ShortMessage();
		mm.setMessage(0x90,randomnote,0x60);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
      tick+=randomrhythm;

		mm = new ShortMessage();
		mm.setMessage(0x80,randomnote,0x40);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
}

// chord #3: 8 beats on F major
while (tick > 4608 && tick < 4801) {

randomnum = rand.nextInt(6 - (1 - 1)) + 1;
randomtick = rand.nextInt(6 - (1 - 1)) + 1;

 if(randomnum == 1){
 randomnote = 65;
 }
 else if(randomnum == 2){
 randomnote = 69;
 }
 else if(randomnum == 3){
 randomnote = 60;
 }
 else if(randomnum == 4){
 randomnote = 72;
 }
 else if(randomnum == 5){
 randomnote = 77;
 }
 else {
 randomnote = 81;
 }
 
 if(randomtick == 1){
 randomrhythm = 6;
 }
 else if(randomtick == 2){
 randomrhythm = 6;
 }
 else if(randomtick == 3){
 randomrhythm = 6;
 }
 else if(randomtick == 4){
 randomrhythm = 6;
 }
 else if(randomtick == 5){
 randomrhythm = 12;
 }
 else {
 randomrhythm = 12;
 }

		mm = new ShortMessage();
		mm.setMessage(0x90,randomnote,0x60);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
      tick+=randomrhythm;

		mm = new ShortMessage();
		mm.setMessage(0x80,randomnote,0x40);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
}

// chord #4: 8 beats on E major
while (tick > 4800 && tick < 4993) {

randomnum = rand.nextInt(6 - (1 - 1)) + 1;
randomtick = rand.nextInt(6 - (1 - 1)) + 1;

 if(randomnum == 1){
 randomnote = 64;
 }
 else if(randomnum == 2){
 randomnote = 68;
 }
 else if(randomnum == 3){
 randomnote = 71;
 }
 else if(randomnum == 4){
 randomnote = 76;
 }
 else if(randomnum == 5){
 randomnote = 80;
 }
 else {
 randomnote = 83;
 }
 
 if(randomtick == 1){
 randomrhythm = 6;
 }
 else if(randomtick == 2){
 randomrhythm = 6;
 }
 else if(randomtick == 3){
 randomrhythm = 6;
 }
 else if(randomtick == 4){
 randomrhythm = 6;
 }
 else if(randomtick == 5){
 randomrhythm = 12;
 }
 else {
 randomrhythm = 12;
 }

		mm = new ShortMessage();
		mm.setMessage(0x90,randomnote,0x60);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
      tick+=randomrhythm;

		mm = new ShortMessage();
		mm.setMessage(0x80,randomnote,0x40);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
}

// chord #5: 8 beats on A minor  (This is where the chord progression repeats)   
while (tick > 4992 && tick < 5185) {

randomnum = rand.nextInt(6 - (1 - 1)) + 1;
randomtick = rand.nextInt(6 - (1 - 1)) + 1;

 if(randomnum == 1){
 randomnote = 57;
 }
 else if(randomnum == 2){
 randomnote = 60;
 }
 else if(randomnum == 3){
 randomnote = 64;
 }
 else if(randomnum == 4){
 randomnote = 69;
 }
 else if(randomnum == 5){
 randomnote = 72;
 }
 else {
 randomnote = 76;
 }
 
 if(randomtick == 1){
 randomrhythm = 6;
 }
 else if(randomtick == 2){
 randomrhythm = 6;
 }
 else if(randomtick == 3){
 randomrhythm = 6;
 }
 else if(randomtick == 4){
 randomrhythm = 6;
 }
 else if(randomtick == 5){
 randomrhythm = 12;
 }
 else {
 randomrhythm = 12;
 }

		mm = new ShortMessage();
		mm.setMessage(0x90,randomnote,0x60);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
      tick+=randomrhythm;

		mm = new ShortMessage();
		mm.setMessage(0x80,randomnote,0x40);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
}

// chord #6: 8 beats on D diminished
while (tick > 5184 && tick < 5377) {

randomnum = rand.nextInt(6 - (1 - 1)) + 1;
randomtick = rand.nextInt(6 - (1 - 1)) + 1;

 if(randomnum == 1){
 randomnote = 59;
 }
 else if(randomnum == 2){
 randomnote = 62;
 }
 else if(randomnum == 3){
 randomnote = 65;
 }
 else if(randomnum == 4){
 randomnote = 68;
 }
 else if(randomnum == 5){
 randomnote = 71;
 }
 else {
 randomnote = 74;
 } 
 
 if(randomtick == 1){
 randomrhythm = 6;
 }
 else if(randomtick == 2){
 randomrhythm = 6;
 }
 else if(randomtick == 3){
 randomrhythm = 6;
 }
 else if(randomtick == 4){
 randomrhythm = 6;
 }
 else if(randomtick == 5){
 randomrhythm = 12;
 }
 else {
 randomrhythm = 12;
 }

		mm = new ShortMessage();
		mm.setMessage(0x90,randomnote,0x60);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
      tick+=randomrhythm;

		mm = new ShortMessage();
		mm.setMessage(0x80,randomnote,0x40);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
}

// chord #7: 8 beats on F major
while (tick > 5376 && tick < 5569) {

randomnum = rand.nextInt(6 - (1 - 1)) + 1;
randomtick = rand.nextInt(6 - (1 - 1)) + 1;

 if(randomnum == 1){
 randomnote = 65;
 }
 else if(randomnum == 2){
 randomnote = 69;
 }
 else if(randomnum == 3){
 randomnote = 60;
 }
 else if(randomnum == 4){
 randomnote = 72;
 }
 else if(randomnum == 5){
 randomnote = 77;
 }
 else {
 randomnote = 81;
 }
 
 if(randomtick == 1){
 randomrhythm = 6;
 }
 else if(randomtick == 2){
 randomrhythm = 6;
 }
 else if(randomtick == 3){
 randomrhythm = 6;
 }
 else if(randomtick == 4){
 randomrhythm = 6;
 }
 else if(randomtick == 5){
 randomrhythm = 12;
 }
 else {
 randomrhythm = 12;
 }

		mm = new ShortMessage();
		mm.setMessage(0x90,randomnote,0x60);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
      tick+=randomrhythm;

		mm = new ShortMessage();
		mm.setMessage(0x80,randomnote,0x40);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
}

// chord #8: 8 beats on E major
while (tick > 5568 && tick < 5761) {

randomnum = rand.nextInt(6 - (1 - 1)) + 1;
randomtick = rand.nextInt(6 - (1 - 1)) + 1;

 if(randomnum == 1){
 randomnote = 64;
 }
 else if(randomnum == 2){
 randomnote = 68;
 }
 else if(randomnum == 3){
 randomnote = 71;
 }
 else if(randomnum == 4){
 randomnote = 76;
 }
 else if(randomnum == 5){
 randomnote = 80;
 }
 else {
 randomnote = 83;
 }
 
 if(randomtick == 1){
 randomrhythm = 6;
 }
 else if(randomtick == 2){
 randomrhythm = 6;
 }
 else if(randomtick == 3){
 randomrhythm = 6;
 }
 else if(randomtick == 4){
 randomrhythm = 6;
 }
 else if(randomtick == 5){
 randomrhythm = 12;
 }
 else {
 randomrhythm = 12;
 }

		mm = new ShortMessage();
		mm.setMessage(0x90,randomnote,0x60);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
      
      tick+=randomrhythm;

		mm = new ShortMessage();
		mm.setMessage(0x80,randomnote,0x40);
		me = new MidiEvent(mm,(long)tick);
		t.add(me);
}

// play an "A" note at the end of solo 3
mm = new ShortMessage();
		mm.setMessage(0x90,69,0x60);
		me = new MidiEvent(mm,(long)5761);
		t.add(me);

		mm = new ShortMessage();
		mm.setMessage(0x80,69,0x40);
		me = new MidiEvent(mm,(long)5785);
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
