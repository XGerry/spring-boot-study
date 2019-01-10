package x.gerry.service;

import x.gerry.model.vo.DemoInfo;

import java.util.List;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/10
 */
public interface IDemoInfoService {
    List<DemoInfo> insertDemoInfo(DemoInfo demo);

    DemoInfo findDemoInfo(Integer id);

    List<DemoInfo> updateDemoInfo(DemoInfo demo);

    List<DemoInfo> deleteDemoInfo(DemoInfo demo);

    List<DemoInfo> findAll();
}
