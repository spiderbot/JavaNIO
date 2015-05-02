import static java.lang.System.*;

import java.io.*;
import java.nio.*;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.util.*;
public class NIODemo2 {
	public static void main(String[] args) throws Exception
	{
		RandomAccessFile raf = new RandomAccessFile("text.txt","rw");
		FileChannel fc = raf.getChannel();
		ByteBuffer bb = ByteBuffer.allocate(48);
		int bytesRead = fc.read(bb);
		while(bytesRead != -1)
		{
			System.out.println("Read bytes = " + bytesRead);
			bb.flip();
			while(bb.hasRemaining())
			{
				System.out.println((char)bb.get());
			}
			bb.compact();
			bytesRead = fc.read(bb);
		}
	}
}
