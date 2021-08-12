package edu.miu.cs545.project.onlinestore.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
//
//    @Autowired
//    UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    BuyerService buyerService;
//
//    @Autowired
//    SellerServiceImpl sellerService;
//
//    @Autowired
//    ModelMapper modelMapper;
//
//    @GetMapping({"/current"})
//    public @ResponseBody
//    UserDTO getCurrentUser() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDetailsImpl userdetails = (UserDetailsImpl) auth.getPrincipal();
//        return modelMapper.map(userdetails.getUser(), UserDTO.class);
//    }
//
//    @GetMapping({"/mysellerinfo"})
//    public @ResponseBody
//    SellerDTO getCurrentSeller() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDetailsImpl userdetails = (UserDetailsImpl) auth.getPrincipal();
//        List<Seller> sellerList = sellerService.getAll();
//        Optional<Seller> seller = sellerList
//                .stream()
//                .filter(s -> s.getUser().getUsername().compareToIgnoreCase(userdetails.getUsername()) == 0).findFirst();
//        if (seller.isPresent())
//            return modelMapper.map(seller.get(), SellerDTO.class);
//        return null;
//    }
//
//    @GetMapping({"/mybuyerinfo"})
//    public @ResponseBody
//    BuyerDTO getCurrentBuyer() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDetailsImpl userdetails = (UserDetailsImpl) auth.getPrincipal();
//        Optional<Buyer> buyer = buyerService.findAll().stream().filter(x -> x.getUser().getUsername().equalsIgnoreCase(userdetails.getUsername())).findFirst();
//        if (buyer.isPresent())
//            return modelMapper.map(buyer.get(), BuyerDTO.class);
//        return null;
//    }
//
//    @PostMapping("/update")
//    public @ResponseBody
//    UserDTO updateSellerProfile(@RequestBody NewUser updateUser) {
//        User user = userDetailsService.updateProfile(updateUser);
//        if (user != null)
//            return modelMapper.map(user, UserDTO.class);
//        return null;
//    }

}