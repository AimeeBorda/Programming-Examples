package trees.AVL;


import java.util.ArrayList;
import java.util.List;

public class AVLTest {

//    AVL a;
//
//    @Before
//    public void setUp(){
//        a = new AVL<Integer,Integer>();
//
//        for (int i = 1; i < 25; i++) {
//            a.insert(i, i);
//        }
//    }
//
//    @Test
//    public void testSetUp() {
//        assertTrue("is Balanced", heightIfBalanced(a.root) > 0);
//        assertEquals("in order traversal", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24", a.traversal());
//    }
//
//    @Test
//    public void testDelete() {
//        a.delete(13);
//        a.delete(5);
//        a.insert(1, 3);
//        assertTrue("is Balanced first", heightIfBalanced(a.root) > 0);
//        a.delete(1);
//        a.delete(6);
//        a.delete(7);
//        assertTrue("is Balanced second", heightIfBalanced(a.root) > 0);
//        a.delete(33);
//        a.delete(21);
//        a.delete(24);
//        a.delete(22);
//        assertTrue("is Balanced third", heightIfBalanced(a.root) > 0);
//        assertEquals("in order traversal", "2,3,4,8,9,10,11,12,14,15,16,17,18,19,20,23", a.traversal());
//
//    }
//
//    @Test
//    public void testSearch(){
//        assertNull("no item", a.search(25));
//        assertEquals(" 23 should return 23",23, a.search(23));
//    }
//
//
//    private int heightIfBalanced(TreeNode node){
//        if(node == null)
//            return 0;
//        else {
//            int hl = heightIfBalanced(node.left);
//            int hr = heightIfBalanced(node.right);
//
//            if(hr - hl < -1 || hr - hl > 1) {
//                System.out.println(hl+","+hr+","+node.value);
//                return 0;
//            }else
//
//     return 1 + Math.max(hr,hl);
//        }
//    }

    public static void  main(String[] args){
//        GlobalBooks globalBooks = new GlobalBooks();

        List<Book> bookList  = new ArrayList<Book>();


        Book book = new Book();
        List<BookContent> bookContents = new ArrayList<BookContent>();

        book.setBookName("A");
        BookContent content = new BookContent();
        content.setDescription("December 2016");
        content.setComponentID(20l);
        bookContents.add(content);

        content = new BookContent();
        content.setDescription("January 2016");
        content.setComponentID(30l);
        bookContents.add(content);

        content = new BookContent();
        content.setDescription("Febuary 2016");
        content.setComponentID(40l);
        bookContents.add(content);
        book.setContents(bookContents);

        bookList.add(book);


        book = new Book();
        bookContents = new ArrayList<BookContent>();

        book.setBookName("B");
        content.setDescription("December 2016");
        content.setComponentID(20l);

        content = new BookContent();
        content.setDescription("January 2016");
        content.setComponentID(30l);
        bookContents.add(content);

        content = new BookContent();
        content.setDescription("Febuary 2016");
        content.setComponentID(40l);
        bookContents.add(content);
        book.setContents(bookContents);

        bookList.add(book);

//        globalBooks.setBooks(bookList);


//        System.out.println(globalBooks);
//        Map<String, List<Book>> byDept
//                = bookList.stream()
//                .collect(Collectors.groupingBy(Book::getDescription));


    }

    private static class BookContent{
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public long getId() {
            return id;
        }

        public void setComponentID(long id) {
            this.id = id;
        }

        private String description;


        private long id;

    }

    private static class Book {
        private List<BookContent> content;

        public List<BookContent> getContent() {
            return content;
        }

        public void setContents(List<BookContent> content) {
            this.content = content;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        private String bookName;


    }
}
