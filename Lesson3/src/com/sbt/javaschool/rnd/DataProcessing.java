package com.sbt.javaschool.rnd;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class DataProcessing {

    private LinkedHashSet hash_words = new LinkedHashSet();
    private ArrayList<String>  list_words = new ArrayList();
    private ArrayList<String>  list_line_file = new ArrayList();

    public void ReadFile() throws IOException {
        String fileName = "C:\\Users\\Пользователь\\IdeaProjects\\Lesson3\\src\\com\\sbt\\javaschool\\rnd\\text.txt";
        Scanner s = new Scanner(new File(fileName));
        String line;
        //ArrayList<String> list = new ArrayList<String>();
        while (s.hasNextLine()){
            line = s.nextLine();
            list_line_file.add(line);
            for (String retval : line.split(" ", 5)) {

                    list_words.add(retval.trim());
                    hash_words.add(retval.trim());
            }
        }
        s.close();
        list_words.removeAll(Arrays.asList("",null));
    }

    public void OutputNumberOfWordsInAFile()
    {

        System.out.println("1) Количество различных слов в файле: " + hash_words.size());
    }

    public void OutputNumberOfWordSize()
    {
        System.out.println("2) Список слов в файле, по возрастанию длины:");
        System.out.println("До сортировки: ");
        System.out.println(list_words);
        Collections.sort(list_words, Comparator.comparing(String::length));
        System.out.println("После сортировки: ");
        System.out.println(list_words);
    }

    public void OutputDuplicateWords() {

        System.out.println("3) Список повторов каждого слова в файле:");
        Collections.sort(list_words, Comparator.comparing(String::length));
        int counter = 0;

        for (int i = 0; i < list_words.size(); i++)
        {
            for (int j = 0; j < list_words.size(); j++)
            {
                if(list_words.get(i).equals(list_words.get(j)) == true)
                {
                    counter++;
                }
            }
            System.out.println(i + 1 + ") " + list_words.get(i) + " - " + counter);
            counter = 0;
        }
    }

    public void OutputReverseLineFile()
    {
        System.out.println("4) Выведите на экран строки файла в обратном порядке:");
        System.out.println("До:");
        System.out.println(list_line_file);
        Collections.reverse(list_line_file);
        System.out.println("После:");
        System.out.println(list_line_file);
    }

    public void OutputReverseLineFileWithMyIterator()
    {
        System.out.println("5) Обход списка в обратном порядке используюя свой итератор:");

        IteratorList list = new IteratorList(list_words);

        for(Object arr: list)
        {
            System.out.print(arr + ", ");
        }
        System.out.println("");
    }

    public void OutputEnteredUserNumLines()
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer>  numbers = new ArrayList();
        int size_list = list_line_file.size()-1;
        Collections.sort(list_line_file);
        System.out.println("6) Вывод строк файла по номеру строки: ");
        System.out.println("Введите номера строк, до - " + size_list + ":");

        String line = scan.nextLine();

        for(String word: line.split(" ", 10)) {
            numbers.add(Integer.parseInt(word));
        }

        for(int i: numbers) {
            if(i <= size_list) {
                System.out.println("Строка " + i + ": " + list_line_file.get(i));
            }
        }
    }

}


