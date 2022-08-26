package com.charon.test_position_service.controller;

import com.charon.test_position_service.entity.Position;
import com.charon.test_position_service.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/8/25
 **/

@RestController
public class PositionController {
    @Autowired
    private PositionService positionService;


    //查询所有职位信息
    @GetMapping("/position/list")
    public ResponseEntity<List<Position>> getPositionById(){
        return ResponseEntity.ok(positionService.getPosition());
    }

    @PostMapping("/position")
    public ResponseEntity<String> addPosition(Position position){

        positionService.save(position);
        return ResponseEntity.ok("ok");
    }

    @PutMapping("/position")
    public ResponseEntity<String> updatePosition(@RequestBody Position position){

        positionService.updateById(position);
        return ResponseEntity.ok("ok");
    }
    @DeleteMapping("/position/{id}")
    public ResponseEntity<String> deletePosition(@PathVariable Long id){
        positionService.removeById(id);
        return ResponseEntity.ok("ok");
    }
}
