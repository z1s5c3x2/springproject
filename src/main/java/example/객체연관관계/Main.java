package example.객체연관관계;

public class Main {
    public static void main(String[] args) {

        System.out.println("Main.main");

        //1. 회원가입
        User aObj = User.builder()
                .uno(1)
                .uid("qwe")
                .uName("강호동")
                .build();
        //2. 글쓰기 진행
        Board bObj = Board.builder()
                .bno(1)
                .bTitle("강호동이쓴글")
                .bContent("강호동이쓴내용")
                .writerUser(aObj) // 게시글 객체에 유저 객체
                .build();
        System.out.println(bObj);
        Comment cObj = Comment.builder()
                .cno(1)
                .cContent("댓글1")
                .board(bObj) // 댓글 객체에 게시글 객체 달기
                .build();
        aObj.getMyBoard().add(bObj);
        Board bObj2 = Board.builder().bno(1)
                .bContent("hi").bContent("content").build();
        aObj.getMyBoard().add(bObj2);
        System.out.println("aObj = " + aObj);

    }
}
