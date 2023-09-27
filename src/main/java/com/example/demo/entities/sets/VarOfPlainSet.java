package com.example.demo.entities.sets;

import lombok.Data;

/**
 *  Набор параметров, описывающих изделие Листовка
 */

@Data
public class VarOfPlainSet extends BaseSet {

    public String orient; // вертикальная или горизонтальная
    public String mod; // цветовая модель для печати 4+0 или 4+4
    public String paper; // бумага

}
