package NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class FileChannelTest {
  public static void main(String[] agrs) throws IOException {
	  RandomAccessFile aFile = new RandomAccessFile("D:\\ningmengchang\\workproject\\test\\src\\NIO\\项目部署的方法.txt", "rw");
	  FileChannel inChannel = aFile.getChannel();

	  ByteBuffer buf = ByteBuffer.allocate(48);
	  
	  //使用Charset进行编码和解码
	  CharsetEncoder encoder=Charset.forName("GBK").newEncoder();
	  CharsetDecoder decoder=Charset.forName("GBK").newDecoder();
	 // 获得JVM默认编码方式
	  Charset charset=Charset.defaultCharset();

	  int bytesRead = inChannel.read(buf);
	  while (bytesRead != -1) {

	  System.out.println("Read " + bytesRead);
	  buf.flip();

	  while(buf.hasRemaining()){
	  System.out.print((char) buf.get());
	  }

	  buf.clear();
	  bytesRead = inChannel.read(buf);
	  }
	  aFile.close();
  }
}
