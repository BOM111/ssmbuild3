package com.wxh.controller;

import com.wxh.pojo.Books;
import com.wxh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        System.out.println("==================================");
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        System.out.println(model.getAttribute("list").toString());
        return "allbook";
    }
    @RequestMapping("/toAddBook")
    public String toAddBook(){
        System.out.println("================进入新增书籍===============");
        return "addbook";
    }

    @RequestMapping("/addbook")
    public String addBook(Books books){
        bookService.addBook(books);
        System.out.println(books);
        System.out.println("==============成功添加书籍==============");
        return "redirect:/books/allBook";
    }
    //跳转到书籍修改页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("Qbook",books);
        System.out.println(books);
        return "updatebook";
    }
    //更新书籍信息
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);
        System.out.println("==============成功Update书籍==============");
        System.out.println(books);
        return "redirect:/books/allBook";
    }
    //删除页面跳转del
    @RequestMapping("/d/{bid}")
    public String db(@PathVariable("bid") int id){
        bookService.deleteBookById(id);
        System.out.println("========del==========");
        return "redirect:/books/allBook";
    }
    //书籍的模糊查询
    @RequestMapping("/queryByNmae")
    public String queryByNmae(String queryByNmae,Model model){
        List<Books> book = bookService.queryByNmae(queryByNmae);
        model.addAttribute("list",book);
        System.out.println("查询结果： "+book);
        System.out.println("版本2");
        return "allbook";
    }}