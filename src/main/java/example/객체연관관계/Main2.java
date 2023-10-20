package example.객체연관관계;

public class Main2 {
    public static void main(String[] args) {
        UpperClass aObj = UpperClass.builder().data("A").build();
        LowerClass bObj = LowerClass.builder().data("B").build();
        LowerClass cObj = LowerClass.builder().data("C").build();

        aObj.getLowerRef().add(bObj);
        aObj.getLowerRef().add(cObj);
        System.out.println("AObj = " + aObj);
        bObj.setUpperObj(aObj);
        cObj.setUpperObj(aObj);
        System.out.println("bObj = " + bObj);
        System.out.println("cObj = " + cObj);
        //상위 하위 객체에서 참조객체를 알수있다
    }
}
/*
*
*   카테고리 클래스
*       카테고리 번호
*       카테고리 이름
*         --fk--
*       제품
*
*   제품 클래스
*       제품 번호
*       제품 이름
* *         --fk--
*       카테고리
*       재고
*
*   재고 클래스
*       재고 번호
*       재고 수량
* *         --fk--
*       제품
*
* */