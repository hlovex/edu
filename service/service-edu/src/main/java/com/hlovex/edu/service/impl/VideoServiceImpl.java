package com.hlovex.edu.service.impl;

import com.hlovex.edu.entity.Video;
import com.hlovex.edu.mapper.VideoMapper;
import com.hlovex.edu.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author hlovex
 * @since 2021-02-16
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

}
