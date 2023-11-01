package ezenweb.controller;

import ezenweb.model.dto.MemberDto;
import ezenweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
// @CrossOrigin("http://192.168.17.147:3000")
public class MemberController {
    // Controller -> service
    // Controller <- service
    @Autowired
    MemberService memberService;

    //1 c
    @PostMapping("/post")
    public boolean doPost(@RequestBody MemberDto mdt)
    {
        System.out.println("mdt = " + mdt);
        boolean result = memberService.doPost(mdt);
        return result;
    }

    //3 u
    @PutMapping("/put")
    public boolean doPut(@RequestBody MemberDto mdt)
    {
        System.out.println("mdt = " + mdt);
        boolean result = memberService.doPut(mdt);
        return result;
    }
    //4 d
    @DeleteMapping("/delete")
    public boolean doDelete(@RequestParam int mno)
    {
        System.out.println("mno = " + mno);
        boolean result = memberService.doDelete(mno);
        return result;
    }
    @PostMapping("/findId")
    public String doFindMemberId(@RequestBody MemberDto _dto)
    {
        System.out.println("MemberController.doFindMemberId");
        System.out.println("_dto = " + _dto);
        String findId =memberService.doFindMemberId(_dto);
        return findId;
    }
    @PostMapping("/findPwd")
    public String doFindMemberPwd(@RequestBody MemberDto _dto)
    {
        return memberService.doFindMemberPwd(_dto);
    }
    /*@PostMapping("/login")
    public boolean doLogin(@RequestBody MemberDto _dto )
    {

        return memberService.doLogin(_dto);

    }
    @GetMapping("logout")
    public boolean doLogOut()
    {
        return memberService.doLogOut();
    }*/


    @GetMapping("/get")
    public MemberDto getMember( ){
        return  memberService.getMember();
    }
    @GetMapping("/findByMemail")
    public boolean findByMemail(@RequestParam String memail)
    {
        return memberService.findByMemail(memail);
    }

}
