package com.ohgiraffers.hw1.controller;

import com.ohgiraffers.hw1.model.dto.AniBook;
import com.ohgiraffers.hw1.model.dto.Book;
import com.ohgiraffers.hw1.model.dto.CookBook;
import com.ohgiraffers.hw1.model.dto.Member;

public class LibraryManager {
    private Member mem = null;
    private Book[] bList = new Book[5];
    int count;

    {
        bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
        bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
        bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
        bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
        bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
    }

    public void insertMember(Member mem) {
        this.mem = mem;
    }

    public Member myInfo() {
        return mem;
    }

    public Book[] selectAll() {
        return bList;
    }

    public Book[] searchBook(String keyword) {
        Book[] books = new Book[5];

        for (count = 0; count < books.length; count++) {
            if (bList[count].getTitle().contains(keyword) ) {
                books[count] = bList[count];
            }
        } return books;
    }

    public int rentBook(int index) {
        int result = 0;
        int couponCount = 0;
        bList[index] = bList[index];
        if (bList[index] instanceof AniBook) {
            if (mem.getAge() < ((AniBook) bList[index]).getAccessAge() ) {
                result = 1;
            }
        }
        if (bList[index] instanceof CookBook) {
            if(((CookBook) bList[index]).isCoupon() == true){
                couponCount++;
                result = 2;
            }
        }
        return result;
    }
}
