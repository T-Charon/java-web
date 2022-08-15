package com.blb.mysql_promotion_service.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.comment.entity.PromotionSpace;
import com.blb.mysql_promotion_service.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Charon
 * @Date 2022/8/13
 **/
@RefreshScope
@RestController
public class PromotionSpaceController {
    @Autowired
    private PromotionSpaceService promotionSpaceService;

    @GetMapping("/promotionspacelist/{current}/{size}")
    public ResponseEntity<IPage<PromotionSpace>> getList(@PathVariable int current, @PathVariable int size){
        return ResponseEntity.ok( promotionSpaceService.getList(current,size));
    }

    @GetMapping("/promotionspace/{id}")
    public ResponseEntity< PromotionSpace> getPromotionSpaceById(@PathVariable Long id){
        return ResponseEntity.ok(promotionSpaceService.getById(id));
    }
    @PostMapping("/promotionspace")
    public ResponseEntity<String> addPromotionSpace( PromotionSpace promotionSpace){
        promotionSpaceService.save(promotionSpace);
        return ResponseEntity.ok("ok");
    }

    @PutMapping("/promotionspace")
    public ResponseEntity<String> updatePromotionSpace(@RequestBody PromotionSpace promotionSpace){
        promotionSpaceService.updateById(promotionSpace);
        return ResponseEntity.ok("ok");
    }
    @DeleteMapping("/promotionspace/{id}")
    public ResponseEntity<String> deletePromotionSpace(@PathVariable Long id){
        promotionSpaceService.removeById(id);
        return ResponseEntity.ok("ok");
    }
}
