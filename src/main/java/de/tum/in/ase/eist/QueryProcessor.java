package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

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
            var split = query.split("plus");
            return String.valueOf(parseInt(split[0]) + parseInt(split[1]));
        }
        else {
            return "";
        }
    }
}
