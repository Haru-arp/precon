package com.gdh.precon.contentsCategory.dto;

import com.gdh.precon.channel.domain.Channel;
import com.gdh.precon.channelCategory.domain.ChannelCategory;
import com.gdh.precon.contents.domain.Contents;
import com.gdh.precon.contentsCategory.domain.ContentsCategory;
import lombok.Data;

import java.util.List;

@Data
public class ContentsCategoryResponseDto {
        private int contentsCategoryIdx;
        private String contentsCategoryName;
        private List<Contents> contentsCategoryMaterialList;
        private int channelIdx;

        public ContentsCategoryResponseDto(ContentsCategory contentsCategory){
                this.contentsCategoryIdx = contentsCategory.getContentsCategoryIdx();
                this.contentsCategoryName = contentsCategory.getContentsCategoryName();
                this.contentsCategoryMaterialList = contentsCategory.getContentsCategoryMaterialList();
                this.channelIdx = contentsCategory.getChannel().getChannelIdx();
        }
}
