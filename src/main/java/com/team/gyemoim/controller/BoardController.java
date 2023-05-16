package com.team.gyemoim.controller;

import com.team.gyemoim.dto.BoardDeleteDTO;
import com.team.gyemoim.dto.BoardWriteDTO;
import com.team.gyemoim.service.BoardService;
import com.team.gyemoim.service.ReplyService;
import com.team.gyemoim.vo.BoardVO;
import com.team.gyemoim.vo.PageVO;
import com.team.gyemoim.vo.ReplyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    public final BoardService boardService;

    public final ReplyService replyService;

    // 게시글 목록을 조회하는 메서드
    @GetMapping("/board/notice/list")
    public List<BoardVO> getBoardList(@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
                                      @RequestParam(value = "cntPerPage", required = false, defaultValue = "10") int cntPerPage) throws Exception {
        int total = boardService.countBoard();// 게시글 전체 갯수

        if (nowPage == 0 && cntPerPage == 0) {
            nowPage = 1;
            cntPerPage = 10;
        } else if (nowPage == 0) {
            nowPage = 1;
        } else if (cntPerPage == 0) {
            cntPerPage = 10;
        }

        PageVO pageVO = new PageVO(total, nowPage, cntPerPage);
        System.out.println("BoardController.getBoardList_게시글 총 갯수 : "+ boardService.countBoard());
        System.out.println("BoardController.getBoardList_pageVO : "+ pageVO);
        System.out.println("BoardController.getBoardList_페이징 처리 후 게시글 조회 : "+ boardService.selectBoard(pageVO));

        return boardService.selectBoard(pageVO);// 페이징 처리 후 게시글 조회하기
    }

    
    // 검색 결과를 조회하는 메서드
    @GetMapping("/board/notice/searchList")
    public List<BoardVO> getSearchList(@ModelAttribute("spv") PageVO spv, @RequestParam(value = "nowPage", required = false) int nowPage, @RequestParam(value = "cntPerPage", required = false) int cntPerPage) throws Exception {
        int total = boardService.searchCountBoard(spv);

        if (nowPage == 0 && cntPerPage == 0) {
            nowPage = 1;
            cntPerPage = 10;
        } else if (nowPage == 0) {
            nowPage = 1;
        } else if (cntPerPage == 0) {
            cntPerPage = 10;
        }

        PageVO pageVO = new PageVO(total, nowPage, cntPerPage, spv.getType(), spv.getKeyword());

        return boardService.searchList(pageVO);
    }

    /* 생성 Create */
    /*@PostMapping("/board/notice/writePost")
    public ResponseEntity<String> writePost(BoardWriteDTO boardWriteDTO, @RequestParam("uploadFile") MultipartFile uploadFile) {
        System.out.println("BoardController_writePost_들어왔다!! 오예압 ");
        System.out.println("BoardWriteDTO: " + boardWriteDTO);
        System.out.println("BoardWriteDTO: " + uploadFile);

        try {
            boardWriteDTO.setUploadFile(uploadFile); // BoardWriteDTO 에 uploadFile 필드 설정

            boardService.write(boardWriteDTO);

            return ResponseEntity.ok("BoardController_writePost_Success :D");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("BoardController_writePost_Error: " + e.getMessage());
        }
    }*/


    @PostMapping("/board/notice/writePost")
    public ResponseEntity<String> writePost(@RequestBody BoardWriteDTO boardWriteDTO) {
        try {
            boardService.write(boardWriteDTO);
            return ResponseEntity.ok("BoardController 글 작성 돌아간닷! :D");
        } catch (Exception e) {
            System.out.println("BoardController 글 작성 실패 writePost 에러 발생함 :< ");
            System.out.println("error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("BoardController 글 작성 실패 :< ");
        }
    }


    /* 읽기 Read */
    public BoardVO read(@RequestParam("bid") int bid) throws Exception {

        List<ReplyVO> replyVOList = replyService.reply(bid);
        BoardVO boardVO = boardService.readDetail(bid);


        return boardVO;
    }


    /* 수정 Update */


    /* 삭제 Delete */
    @DeleteMapping("/board/notice/delete")
    public String delete(@RequestBody BoardDeleteDTO dto) throws Exception {
        System.out.println("/board/delete BoardDeleteDTO = " + dto);
        HttpHeaders headers = new HttpHeaders();
        boardService.delete(dto);
        return "";
    }


}
