package org.home.latin.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
        Date now=new Date();
        String dateString = format.format(now);
        System.out.println("Date="+now);
        System.out.println("Date formatted="+dateString);

        List<String> list1 = new ArrayList<String>(Arrays.asList("A", "B", "C"));
        List<String> list2 = new ArrayList<String>(Arrays.asList("B", "C", "D", "E", "F"));

        List<String> intersect1 = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
        List<String> intersect2 = list2.stream()
                .filter(list1::contains)
                .collect(Collectors.toList());
        System.out.println("Filtered1:"+intersect1);
        System.out.println("Filtered2:"+intersect2);

        List<String> diff = list1.stream()
                .filter(e -> !list2.contains(e))
                .collect (Collectors.toList());

        System.out.println("diff1:"+diff);



    }
}
