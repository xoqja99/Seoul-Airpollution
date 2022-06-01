package seoul_airpollution;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirPollution1Mapper extends Mapper<Object, Text, Text, FloatWritable> {

    Text region = new Text();
    FloatWritable figure = new FloatWritable();
    @Override
    protected void map(Object key, Text value, Mapper<Object, Text, Text, FloatWritable>.Context context)
            throws IOException, InterruptedException {
        // 0. 날짜 시간, 1. 지역, 2.오염물질, 3.수치
        String[] line = value.toString().split(",");
        for (String i : line) {
            System.out.println(i);
        }

        if (line[2].equals("8")) {
            region.set(line[1]);
            figure.set(Float.parseFloat(line[3]));
            context.write(region, figure);
        }
    }
}