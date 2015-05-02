import static java.lang.System.*;

import java.io.*;
import java.util.*;
import java.nio.*;
import java.nio.channels.FileChannel;
public class NIODemo3 {
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		RandomAccessFile raf = new RandomAccessFile("input.txt","rw");
		RandomAccessFile raf2 = new RandomAccessFile("output.txt","rw");
		FileChannel fc1 = raf.getChannel();
		FileChannel fc2 = raf2.getChannel();
		long start = 0;
		long end = fc1.size();
		System.out.println(end);
		fc2.transferFrom(fc1, start, end);
		System.out.println("done");
	}
}
