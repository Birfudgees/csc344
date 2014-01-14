import java.io.*;

public class WavProject {
   
   
   // This is my unfinished attempt to adapt Robert Groarke's "WavRearrange" project into something original.
   // I have a lot of questions that probably have embarrasingly simple answers...
   // I've tried so many different ways to alter/replace the reversing and rearranging actions he uses but haven't been able to figure anything out yet.
   // In a lot of the cases, I just ended up with something that either outputs an unplayable file or just doesn't compile at all.
   // Right now, this apparently reverses everything and plays the second third of it at double speed, followed by the first third at normal speed.
   
   
   // Adapted from Ed Foley's implementation of Dr Andrew Greensted's Java Wav
   // File I/O Libraries
   
   public static void main(String[] args)
    {
        try
        {
            int length = 30;     
            
            WavFile wavFileIn = WavFile.openWavFile(new File("StratosIntro.wav"));       
            
                        int sampleRate = (int)(wavFileIn.getSampleRate());
            
            long numFramesIn = wavFileIn.getNumFrames();
            
            long numFramesOut = (long)(length*sampleRate);
            
            WavFile wavFileOut = WavFile.newWavFile(new File("New_StratosIntro.wav"), 2, numFramesOut, 16, sampleRate);
            
            int numChannels = wavFileIn.getNumChannels();

            double[] bufferIn = new double[(int)(numFramesIn * numChannels)];
            
            double[][] bufferOut = new double[numChannels][(int)(numFramesOut)];
            
            wavFileIn.readFrames(bufferIn, (int)numFramesIn);
          
          
          
            
            //Reverses the frames
            for( int i = 0; i<numFramesOut; i++) {              
               bufferOut[0][i] = bufferIn[(int)numFramesOut*2 - 2*i];
               bufferOut[1][i] = bufferIn[(int)numFramesOut*2 - 2*i-1];   
            }
            
            double[][] bufferSpliced = new double[numChannels][(int)(numFramesOut)];
            
            // Puts the second half of the frames in front
            for( int i = 0; i< (int)(numFramesOut/3); i++) {  
               bufferSpliced[0][i + (int)(numFramesOut/3)] = bufferOut[0][i];
               bufferSpliced[1][i + (int)(numFramesOut/3)] = bufferOut[1][i];
            
              
               bufferSpliced[0][i] = bufferOut[0][i + i + (int)(numFramesOut/3)];
               bufferSpliced[1][i] = bufferOut[1][i + i + (int)(numFramesOut/3)];
            
            // Random note:  I thought it would be cool to expand this idea by breaking the audio clip into more than 2 parts, and then placing them all in a new order.  Just ended up running into more and more problems though

              
            }
                        
            
                        
            // write frames in bufferOut to our output file
            wavFileOut.writeFrames(bufferSpliced, (int)numFramesOut);
            
            // Close the wav files
            wavFileIn.close();
            wavFileOut.close();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }    
   
}