import java.util.LinkedList;
import java.util.ListIterator;

public class Optional 
{
	public static void main(String[] args) {

        // form a sorted list by insertion
        System.out.println("A SORTED LIST");
        System.out.println("=============\n\n");
        LinkedList<String> friends = new LinkedList();

        System.out.println("We insert the names Piruli, Echisera, Marquito, ");
        System.out.println("Papa Bill, Ali Baba, Coqueta, Shrek, Geoff the Chef.");

        insert(friends, "Piruli");
        insert(friends, "Echisera");
        insert(friends, "Marquito");
        insert(friends, "Papa Bill");
        insert(friends, "Ali Baba");
        insert(friends, "Coqueta");
        insert(friends, "Shrek");
        insert(friends, "Geoff the Chef");

        // print the list
        printList("The friends list:", friends);

        System.out.println("We delete all names between \"M\" and \"T\" :");
        delete(friends, "M", "T");

        printList("The reduced list:", friends);
    }

    // the list is sorted in increasing order
    // insert item in its proper place in list
    //  if the item is already there, do nothing
    public static <T extends Comparable<? super T>>
            void insert(LinkedList<T> list, T item)
    { 	
    	ListIterator<T> i = list.listIterator();//creates an iterator to traverse list
    	
    	//checks if the item is in the list
    	if (!list.contains(item))
    	{
    		//insert item in proper place
    		while (i.hasNext() && list.get(i.nextIndex()).compareTo(item) < 0)
    		{
    			i.next();
    		}
    		i.add(item);
    	}
    }

    // delete all items between low and high
    // including low and high from list
    // list is not sorted
    public static <T extends Comparable<? super T>>
            void delete(LinkedList<T> list, T low, T high)
    {
    	//traverses the list
    	for (int i = 0; i < list.size(); i++)
        {
        	//checks if item is between low and high
    		if (list.get(i).compareTo(low) >= 0 && list.get(i).compareTo(high) <= 0)
        			{
    					//removes item and decrements the counter
        				list.remove(i);
        				i--;
        			}
        }
    }

    // print the title, underline it, and then print the items of list,
    // one per line.
    public static <T> void printList(String title, LinkedList<T> list)
    {
    	int ln = 0;//the length of the underline
    	//prints the title
    	System.out.println(title);
    	
    	//underlines the title
    	while (ln <= title.length())
    	{
    		System.out.print("=");
    		ln++;
    	}
    	System.out.println("\n");
    	
    	//prints every item in the list
    	for (T item:list)
    	{
    		System.out.println(item);
    	}	
    }
}
