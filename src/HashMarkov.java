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
    public List<String> getFollows(WordGram wgram) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFollows'");
    }

    @Override
    public String getRandomText(int length) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRandomText'");
    }

    @Override
    public int getOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrder'");
    }

    @Override
    public void setSeed(long seed) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSeed'");
    }
    
}
