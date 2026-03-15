package org.example.processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SortQuiz
{
    public Map<String, String> quizMap = new HashMap<>();
    List<String> keys;

    public Map<String, String> CompletedQuizMap = new HashMap<>();


    Random random = new Random();

    public boolean  flag = false;

    public int currentQuiz = 0;

    public String getQuiz()
    {
        while(quizMap.size()!=CompletedQuizMap.size())
        {
            currentQuiz = random.nextInt(keys.size());
            String randomKey = keys.get(currentQuiz);

            flag = CheckQuiz(randomKey);

            if (flag==true)
            {
                flag = false;
                CompletedQuizMap.put(randomKey,quizMap.get(randomKey));
                return randomKey+"";
            }

        }

        return "Вопросы закончились!";
    }


    public boolean CheckQuiz(String quiz)
    {
        if(CompletedQuizMap.containsKey(quiz))
        {
            return false;
        }
        return true;
    }


    public void readQuizesFromFile()
    {
        Scanner scanner;
        try {
            scanner = new Scanner(new File("D:\\projects\\Java\\alabs\\j_lab5\\quizes.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] str_arr = line.split("==");
            quizMap.put(str_arr[0],str_arr[1]);
            //System.out.println(quizMap);
            System.out.println(str_arr[0]);
            System.out.println(str_arr[1]);
        }

        this.keys = new ArrayList<>(quizMap.keySet());
        scanner.close();
    }


    public Map<String, String> getQuizMap()
    {
        return quizMap;
    }



    public boolean checkAnswer(String answer)
    {
        if(quizMap.get(keys.get(currentQuiz)).equals(answer))
        {
            return true;
        }
        return false;
    }

    public String getCorrectAnswer()
    {
        return quizMap.get(keys.get(currentQuiz));
    }



}
