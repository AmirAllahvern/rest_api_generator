package com.amir.springkotlindemo.controller

import com.amir.springkotlindemo.annotation.ApiMapping
import com.amir.springkotlindemo.dto.CreateDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@ApiMapping
class HomeController {
    @GetMapping("rest")
    fun get() : ResponseEntity<String>
    {
        val num : Int = 2
        val intNumber :Int = 2
        val stringNumber :Int = 2
        val floatNumber :Int = 2
        val res = StringBuilder()
        for (i in 1..num){
            res.append("{\n")
            for (numberOfInt in 1..intNumber){
                res.append("\"int $i-$numberOfInt\": $i-$numberOfInt, \n" )
            }
            for (numberOfString in 1..stringNumber){
                res.append("\"string $i-$numberOfString\": \"$i-s $numberOfString\", \n")
            }
            for (numberOfFloat in 1..floatNumber){
                res.append("\"float $i-$numberOfFloat\": $i-${numberOfFloat.toFloat()}, \n" )
            }
            res.append("},\n")
        }

        return ResponseEntity(res.toString(),HttpStatus.OK)
    }

    @PostMapping("rest/{num}")
    fun post(@PathVariable num: Int, @RequestBody create : CreateDto) : ResponseEntity<String>
    {
        val res = StringBuilder()
        for (i in 1..num){
            res.append("{\n")
            for (numberOfInt in 1..create.intNumber){
                res.append("\"int $i-$numberOfInt\": $i-$numberOfInt, \n" )
            }
            for (numberOfString in 1..create.stringNumber){
                res.append("\"string $i-$numberOfString\": \"$i-s $numberOfString\", \n")
            }
            for (numberOfFloat in 1..create.floatNumber){
                res.append("\"float $i-$numberOfFloat\": $i-${numberOfFloat.toFloat()}, \n" )
            }
            res.append("},\n")
        }
        return ResponseEntity(res.toString(), HttpStatus.CREATED)
    }
}