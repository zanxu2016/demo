package com.example.demo.core.tools.recommend;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.springframework.util.CollectionUtils;

public class DisperseTest {


    public static void main(String[] args) throws IOException {
        String filePath = "/Users/xuzan/work/test/demo/core/src/main/resources/";
        String fileName = "7";

        List<Item> items = IOUtils.readLines(new FileInputStream(new File(filePath + fileName)), Charset.defaultCharset()).stream()
                .map(str -> {
                    String[] values = str.split("\\t");
                    int len = values.length;
                    Item.ItemBuilder builder = Item.builder();
                    if (len >= 1) {
                        builder.no(values[0]);
                    }
                    if (len >= 2) {
                        builder.tid(values[1]);
                    }
                    if (len >= 3) {
                        builder.username(values[2]);
                    }
                    if (len >= 4) {
                        builder.modelScore(values[3]);
                    }
                    if (len >= 5) {
                        builder.sortScore(values[4]);
                    }
                    if (len >= 6) {
                        builder.reasonSet(values[5]);
                    }
                    if (len >= 7) {
                        builder.title(values[6]);
                    }
                    if (len >= 8) {
                        builder.topic_id(values[7]);
                    }
                    if (len >= 9) {
                        builder.posttype(values[8]);
                    }
                    if (len >= 10) {
                        builder.keyword(values[9]);
                    }
                    if (len >= 11) {
                        builder.replies(values[10]);
                    }
                    return builder.build();
                })
                .collect(Collectors.toList());

        int keywordGapSize = 6;
//        checkKeywordDisperse(keywordGapSize, items);

        int topicIdGapSize = 2;
        checkTopicDisperse(topicIdGapSize, items);
    }

    // 校验话题（topic）打散结果
    public static void checkTopicDisperse(int topicGapSize, List<Item> items) {
        System.out.println("checkTopicDisperse ===> ");
        int pointer = 0;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (i >= items.size() - topicGapSize - 1) {
                pointer = items.size();
            } else {
                pointer = i + topicGapSize + 1;
            }
            String targetTopicId = item.getTopic_id();
            if (StringUtils.isBlank(targetTopicId) || "NaN".equals(targetTopicId) || "0".equals(targetTopicId)) {
                continue;
            }
            List<Item> forwardItems = items.subList(i + 1, pointer);
            boolean disperseRes = forwardItems.stream()
                    .map(Item::getTopic_id)
                    .filter(topicId -> StringUtils.isNotBlank(topicId) && !"NaN".equals(topicId) && !"0".equals(topicId))
                    .anyMatch(targetTopicId::equals);
            System.out.println(String.format("tid: %s, disperseRes: %s", item.getTid(), disperseRes));
        }
        System.out.println();
    }

    // 校验关键字（keyword）打散结果
    public static void checkKeywordDisperse(int keywordGapSize, List<Item> items) {
        System.out.println("checkKeywordDisperse ===> ");
        int pointer = 0;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (i >= items.size() - keywordGapSize - 1) {
                pointer = items.size();
            } else {
                pointer = i + keywordGapSize + 1;
            }
            String targetKW = item.getKeyword();
            if (StringUtils.isBlank(targetKW) || "NaN".equals(targetKW) || "0".equals(targetKW)) {
                continue;
            }
            List<Item> forwardItems = items.subList(i + 1, pointer);
            boolean disperseRes = forwardItems.stream()
                    .map(Item::getKeyword)
                    .filter(kw -> StringUtils.isNotBlank(kw) && !"NaN".equals(kw) && !"0".equals(kw))
                    .anyMatch(keyword -> CollectionUtils.containsAny(Arrays.asList(targetKW.split(",")), Arrays.asList(keyword.split(","))));
            System.out.println(String.format("tid: %s, disperseRes: %s", item.getTid(), disperseRes));
        }
        System.out.println();
    }

    @Builder
    @Data
    static class Item {
        private String no;
        private String tid;
        private String username;
        private String modelScore;
        private String sortScore;
        private String reasonSet;
        private String title;
        private String topic_id;
        private String posttype;
        private String keyword;
        private String replies;
    }
}
