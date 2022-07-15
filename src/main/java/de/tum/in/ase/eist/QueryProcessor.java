package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "awef";
        } else if (query.contains("plus")) { // TODO extend the programm here
            var split = query.split("%20");
            int i = 0;
            for(; i < split.length; ++i) {
                if (split[i].equals("plus")) {
                    break;
                }
            }
            return String.valueOf(parseInt(split[i-1]) + parseInt(split[i+1]));
        }
        else if (query.contains("largest")){
            var n = query.split("largest:");
            var num = Arrays.stream(n[1].split(",")).map(a->a.replace("%20", "")).map(Integer::parseInt).reduce(Math::max);
            return String.valueOf(num.get());
        }
        else {
            return "";
        }
    }

    public static void main(String[] args) {
        String a = "26d7af00:%20which%20of%20the%20following%20numbers%20is%20the%20largest:%20829,%20647,%201,%2029";//.replace("%20", " ");
        String x = new QueryProcessor().process(a);
        System.out.println();
    }
}
