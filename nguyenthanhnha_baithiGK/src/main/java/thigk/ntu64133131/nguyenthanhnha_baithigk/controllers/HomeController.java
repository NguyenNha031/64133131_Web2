package thigk.ntu64133131.nguyenthanhnha_baithigk.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thigk.ntu64133131.nguyenthanhnha_baithigk.model.Student;
import thigk.ntu64133131.nguyenthanhnha_baithigk.model.Topic;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private static final List<Topic> topics = new ArrayList<>();
    private static final List<Student> students = new ArrayList<>();

    static {
        topics.add(new Topic(1, "AI Research", "Study about AI", "T001", "Research"));
        topics.add(new Topic(2, "Web Development", "Create modern web apps", "T002", "Project"));

        students.add(new Student(1, "Nguyễn Văn A", "G1"));
        students.add(new Student(2, "Trần Thị B", "G2"));
    }

    @GetMapping("/")
    public String redirectToSBAdmin() {
        return "indexSB";
    }

    @GetMapping("/homepage")
    public String home1() {
        return "fragments/contentSB";
    }

    @GetMapping("/topic/list")
    public String listTopics(Model model) {
        model.addAttribute("topics", topics);
        return "topicList";
    }

    @GetMapping("/student/list")
    public String listStudents(Model model) {
        model.addAttribute("students", students);
        return "studentList";
    }

    @GetMapping("/topic/view/{id}")
    @ResponseBody
    public Topic viewTopic(@PathVariable int id) {
        return topics.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }



    @GetMapping("/topic/addnew")
    public String showAddTopicForm(Model model) {
        Topic newTopic = new Topic(0, "", "", "", "");
        model.addAttribute("newTopic", newTopic);
        return "topic_addnew";
    }

    @PostMapping("/topic/add")
    public String addTopic(@ModelAttribute("newTopic") Topic topic, Model model) {
        try {
            int newId = topics.isEmpty() ? 1 : topics.get(topics.size() - 1).getId() + 1;
            topic.setId(newId);
            topics.add(topic);
            return "redirect:/topic/list";
        } catch (Exception e) {
            model.addAttribute("error", "Error adding topic: " + e.getMessage());
            return "topic_addnew";
        }
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        students.removeIf(s -> s.getId() == id);
        return "indexSB";
    }
    @GetMapping("/deleteTopic/{id}")
    public String deleteTopic(@PathVariable int id) {
        topics.removeIf(t -> t.getId() == id);
        return "indexSB";
    }

    @GetMapping("/error")
    public String handleError() {
        return "error";

    }
}

