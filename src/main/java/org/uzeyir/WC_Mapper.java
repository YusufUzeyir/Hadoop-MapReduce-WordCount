package org.uzeyir;
import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class WC_Mapper extends Mapper<LongWritable, Text, Text, Text> {

    private Text word = new Text();
    private Text documentName = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String fileName = ((FileSplit) context.getInputSplit()).getPath().getName();
        documentName.set(fileName);

        // Metni boşluklara göre kelimelere ayırdım
        String[] words = value.toString().split("\\s+");

        for (String w : words) {
            // Noktalamadan temizleme işlemi yapıyorum.
            w = w.replaceAll("[^\\p{L}\\p{Nd}]+", ""); // Sadece harfler ve sayılar kalsın

            // Temizlenen kelime boş değilse yazma işlemini yapıyorum.
            if (w.length() > 0) {
                word.set(w);
                context.write(word, documentName);
            }
        }
    }
}
