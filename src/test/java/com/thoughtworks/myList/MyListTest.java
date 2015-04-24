package com.thoughtworks.myList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
public class MyListTest {

    @Test
    public void should_return_size_of_list (){
        MyList<String> myList = new MyList<String>();
        assertThat(myList.size()).isEqualTo(0);
    }

    @Test
    public void can_judge_whether_list_is_empty(){
        MyList<String> myList = new MyList<String>();
        assertThat(myList.isEmpty()).isEqualTo(true);
    }

    @Test
    public void can_judge_whether_include_special_object(){
        MyList<String> myList = new MyList<String>();
        assertThat(myList.contains("hello")).isEqualTo(false);

        myList.add("hello");
        assertThat(myList.contains("hello")).isEqualTo(true);
    }

    @Test
    public void can_transfer_list_to_array(){
        MyList<String> myList = new MyList<String>();
        myList.add("hello");

        assertThat(myList.toArray().length).isEqualTo(1);
    }

    @Test
    public void can_add_a_object_to_list(){
        MyList<String> myList = new MyList<String>();
        myList.add("hello");

        assertThat(myList.size()).isEqualTo(1);
    }

    @Test
    public void can_remove_special_object(){
        MyList<String> myList = new MyList<String>();
        myList.add("hello");
        myList.add("world");

        assertThat(myList.remove("apple")).isEqualTo(false);
        assertThat(myList.size()).isEqualTo(2);

        assertThat(myList.remove("hello")).isEqualTo(true);
        assertThat(myList.size()).isEqualTo(1);
    }

    @Test
    public void can_add_a_collection(){

        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");

        assertThat(list.size()).isEqualTo(2);

        MyList<String> myList = new MyList<String>();
        assertThat(myList.addAll(list)).isEqualTo(true);
        assertThat(myList.size()).isEqualTo(2);

        List<String> emptyList = new ArrayList<String>();
        assertThat(myList.addAll(emptyList)).isEqualTo(false);
    }

    @Test
    public void can_add_a_collection_by_special_index(){

        List<String> list = new ArrayList<String>();

        MyList<String> myList = new MyList<String>();
        myList.add("a");
        myList.add("b");

        assertThat(myList.addAll(1, list)).isEqualTo(false);

        list.add("hello");
        assertThat(myList.addAll(1, list)).isEqualTo(true);
    }

    @Test
    public void should_clear_all_elements(){
        MyList<String> myList = new MyList<String>();

        myList.add("world");
        myList.clear();

        assertThat(myList.size()).isEqualTo(0);
    }

    @Test
    public void should_get_element_by_index(){
        MyList<String> myList = new MyList<String>();
        myList.add("hello");
        myList.add("world");

        assertThat(myList.get(0)).isEqualTo("hello");
    }

    @Test
    public void should_set_element_and_return_previous_one(){
        MyList<String> myList = new MyList<String>();
        myList.add("green");

        assertThat(myList.set(0, "red")).isEqualTo("green");
    }

    @Test
    public void can_insert_element_by_index(){
        MyList<String> myList = new MyList<String>();

        myList.add("I");
        myList.add("girl");

        myList.add(1, "a");

        assertThat(myList.size()).isEqualTo(3);
        assertThat(myList.get(1)).isEqualTo("a");
    }

    @Test
    public void can_remove_element_by_index(){
        MyList<String> myList = new MyList<String>();
        myList.add("good");
        myList.add("morning");
        myList.add("world");

        assertThat(myList.remove(1)).isEqualTo("morning");
        assertThat(myList.size()).isEqualTo(2);
    }

    @Test
    public void should_get_the_index_of_element(){
        MyList<String> myList = new MyList<String>();
        myList.add("good");
        myList.add("morning");
        myList.add("world");

        assertThat(myList.indexOf("morning")).isEqualTo(1);
        assertThat(myList.indexOf("girl")).isEqualTo(-1);
    }

    @Test
    public void should_get_last_index_of_element(){
        MyList<String> myList = new MyList<String>();
        myList.add("good");
        myList.add("morning");
        myList.add("good");

        assertThat(myList.lastIndexOf("good")).isEqualTo(2);
        assertThat(myList.indexOf("girl")).isEqualTo(-1);
    }

    @Test
    public void should_get_range_index_of_list(){
        MyList<String> myList = new MyList<String>();
        myList.add("good");
        myList.add("morning");
        myList.add("world");

        assertThat(myList.subList(1,2).size()).isEqualTo(2);
        assertThat(myList.subList(1,2).get(0)).isEqualTo("morning");
    }
}