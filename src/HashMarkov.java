import java.util.*;

public class HashMarkov implements MarkovInterface {
    protected String[] myWords;
    protected Random myRandom;
    protected int myOrder;
    protected HashMap<WordGram, List<String>> myMap = new HashMap <WordGram, List<String>>();

    HashMarkov(int order) {
        myOrder = order;
        myRandom = new Random();
        myMap = new HashMap<>();
    }


    @Override
    public void setTraining(String text) {
        myMap.clear();
        myWords = text.split("\\s+");

        for (int k = 0; k < myWords.length - myOrder; k++){
            WordGram wGram = new WordGram(myWords, k, myOrder);
            myMap.putIfAbsent(wGram, new ArrayList<String>());
            myMap.get(wGram).add(myWords[k + myOrder]);
        }
    }

        
    @Override
    public List<String> getFollows(WordGram wGram) {
        List<String> follows = new ArrayList<>();
        follows = myMap.get(wGram);
        if (follows != null) {
            return follows;
        }
        else {
            List<String> newFollows = new ArrayList<>();
            follows = newFollows;
        }
        return follows; 
    }

    private String getNext(WordGram wGram) {
        List<String> follows = getFollows(wGram);
        if (follows.size() == 0) {
            int randomIndex = myRandom.nextInt(myWords.length);
            follows.add(myWords[randomIndex]);
        }
    }

    @Override
    public String getRandomText(int length) {
        ArrayList<String> randomWords = new ArrayList<>(length);
        int index = myRandom.nextInt(myWords.length - myOrder + 1);
        WordGram current = new WordGram(myWords, index, myOrder);
        randomWords.add(current.toString());

            for (int i=0; i<length - myOrder; i += 1);
                String nextWord = getNext(current);
                randomWords.add(nextWord);

    }

    @Override
    public int getOrder() {
        return myOrder;
    }

    @Override
    public void setSeed(long seed) {
        myRandom.setSeed(seed);
    }
    
}
