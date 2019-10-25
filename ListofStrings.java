import java.util.NoSuchElementException;

public class ListofStrings {

    private String[] items;
    private int N;

    public ListofStrings(){
        items = new String[1];
        N = 0;
    }

    private void resize(int capacity){
        String[] temp = new String[capacity];
        for (int i = 0; i < N; i++)
            temp[i] = items[i];
        items = temp;
    }

    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N == 0;
    }

    public void add (String item){
        if(item==null)
            throw new IllegalArgumentException();
        if(N == items.length)
            resize(2 * items.length);
        items[N++] = item;
    }

    public String remove (){
        if(N == 0)
            throw new NoSuchElementException();
        String v = items[N-1];
        items[N-1] = null;
        N--;
        if (N > 0 && N == items.length/4)
            resize(items.length/2);
        return v;
    }

    public String get (int position){
        if(position < 0 || position >= N)
            throw new NoSuchElementException();
        return items[position];
    }

    public int position (String item){
        if(item==null)
            throw new IllegalArgumentException();
        for(int i=0; i<=N; i++)
            if(items[i].equals(item))
                return i;
        return -1;
    }

    // implementation of the following APIs are left to the student
    public void add(String item, int position){
        if (position<0 || position>N) throw new IndexOutOfBoundsException();
        String tmp=items[position],tmp2;
        if (items.length+1==N) resize(items.length*2);
        items[position]=item;
        N++;
        for(int i=position+1;i<N;i++){
            tmp2=items[i+1];
            items[i]=tmp;
            tmp=tmp2;


        }
    }

     public void remove(int position){
        if (isEmpty()) throw new NoSuchElementException();
        if (position<0 || position >=N ) throw  new IndexOutOfBoundsException();
        if (position==N-1) remove();else {
            //String tmp = items[position + 1];
            for(int i=position;i<items.length-1;i++){
                items[i]=items[i+1];


            }

            items[N-1] = null;
            N--;
            if (N > 0 && N == items.length/4)
                resize(items.length/2);
        }

     }
     public String max(){
        String tmp=items[0];
        for(int i=1;i<items.length;i++){
            if(tmp.compareTo(items[i])<=0) tmp=items[i];
        }
        return tmp;
     }



}


