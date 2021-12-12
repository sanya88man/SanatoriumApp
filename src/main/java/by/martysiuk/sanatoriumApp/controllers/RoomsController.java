package by.martysiuk.sanatoriumApp.controllers;

import by.martysiuk.sanatoriumApp.models.Room;
import by.martysiuk.sanatoriumApp.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

@Controller
public class RoomsController {
    private final RoomService roomService;

    @Autowired
    public RoomsController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public String showRooms(Model model) {
        model.addAttribute("rooms", roomService.showRooms());
        return "rooms/showRooms";
    }

    @GetMapping("/admin/rooms/edit")
    public String showRoomsForEdit(Model model) {
        model.addAttribute("rooms", roomService.showRooms());
        return "rooms/showRoomsForEdit";
    }

    @GetMapping("/admin/rooms/{id}/editRoom")
    public String editRoom(Model model, @PathVariable("id") int id) {
        model.addAttribute("room", roomService.showRoom(id));
        return "rooms/editRoom";
    }

    @PatchMapping("/admin/rooms/{id}")
    public String updateRoom(@PathVariable int id, @ModelAttribute("room") @Valid Room room,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "rooms/editRoom";
        }
        room.setId(id);
        roomService.updateRoom(room);
        return "redirect:/admin/rooms/edit";
    }

    /*@GetMapping("/user/routs/{id}")
    public String showRout(@PathVariable("id") int id, Model model,
                           GregorianCalendar calendar,
                           SimpleDateFormat simpleDateFormat) {
        String[] arr = roomService.showDates(calendar, simpleDateFormat);
        model.addAttribute("rout", roomService.showRout(id));
        model.addAttribute("id", id);
        model.addAttribute("s1", arr[0]);
        model.addAttribute("s2", arr[1]);
        model.addAttribute("s3", arr[2]);
        return "routs/showRout";
    }*/
}
