import com.thoughtworks.myList.MyList;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> myList = new MyList<String>();

        myList.add("hello");
        myList.add(", ");
        myList.add("world");
        myList.add("!");

        String string = "";
        for(int i=0; i<myList.size(); i++){
            string += myList.get(i);
        }

        System.out.println("The sentence has "  + myList.size() + " elements. It is \"" + string +"\".");
    }
}