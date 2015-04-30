import static java.lang.System.*;

import java.io.*;
import java.util.*;
import java.nio.*;
import java.nio.channels.FileChannel;
public class NIODemo {
	public static void main(String[] args) throws Exception
	{
		RandomAccessFile raf = new RandomAccessFile("hello.txt","rw");
		FileChannel channel = raf.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(48);
		int bytesRead = channel.read(buffer);
		int lineNumber = 1;
		while(bytesRead != -1)
		{
			System.out.println("Read " + bytesRead);
			buffer.flip();
			System.out.print(lineNumber++ + "  ");

			while(buffer.hasRemaining())
			{
				System.out.print((char)buffer.get());
			}
			buffer.clear();
			bytesRead = channel.read(buffer);
		}
	}
}
