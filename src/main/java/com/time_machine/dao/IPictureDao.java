package com.time_machine.dao;

import com.time_machine.pojo.Picture;

public interface IPictureDao {
    public Picture getPicture(long id);
    public void deletePicture(Picture picture);
    public void insertPicture(Picture picture);
    public void updatePicture(Picture picture);
}
