package x.gerry.service.Impl;

import org.springframework.stereotype.Service;
import x.gerry.dao.DemoVoMapper;
import x.gerry.model.vo.DemoInfo;
import x.gerry.service.IDemoInfoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/10
 */
@Service
public class DemoInfoServiceImpl implements IDemoInfoService {

    @Resource
    DemoVoMapper demoVoMapper;

    @Override
    public List<DemoInfo> insertDemoInfo(DemoInfo demo) {
        return demoVoMapper.insertDemoInfo(demo);
    }

    @Override
    public DemoInfo findDemoInfo(Integer id) {
        return demoVoMapper.findDemoInfo(id);
    }

    @Override
    public List<DemoInfo> updateDemoInfo(DemoInfo demo) {
        return demoVoMapper.updateDemoInfo(demo);
    }

    @Override
    public List<DemoInfo> deleteDemoInfo(DemoInfo demo) {
        return demoVoMapper.deleteDemoInfo(demo);
    }

    @Override
    public List<DemoInfo> findAll() {
        return demoVoMapper.findAll();
    }
}
