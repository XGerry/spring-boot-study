package x.gerry.dao;

import org.springframework.stereotype.Repository;
import x.gerry.model.vo.DemoInfo;

import java.util.*;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/10
 */
@Repository
public class DemoVoMapper {
    public static Map<Integer, DemoInfo> map =Collections.synchronizedMap(new HashMap<>());

    static {
        for (int i = 0; i < 10; i++) {
            DemoInfo info = new DemoInfo();
            info.setId(++i);
            info.setName("name_" + i);
            info.setDesc("我是第" + i + "个同学！");
            map.put(i, info);
        }
    }

    public List<DemoInfo> insertDemoInfo(DemoInfo demoInfo) {
        map.put(demoInfo.getId(), demoInfo);
        return getListDemoInfo(map);
    }

    public DemoInfo findDemoInfo(Integer id){
        return map.get(id);
    }

    public List<DemoInfo> updateDemoInfo(DemoInfo demo) {
        map.replace(demo.getId(), demo);
        List<DemoInfo> list = getListDemoInfo(map);
        return list;
    }

    public List<DemoInfo> deleteDemoInfo(DemoInfo demo) {
        map.remove(demo.getId());
        return getListDemoInfo(map);
    }

    public List<DemoInfo> findAll() {
        List<DemoInfo> list = getListDemoInfo(map);
        return list;
    }

    private List<DemoInfo> getListDemoInfo(Map<Integer, DemoInfo> map) {
        Set<Integer> set = map.keySet();
        List<DemoInfo> list = new ArrayList<>();
        for (Integer id : set) {
            DemoInfo demo = map.get(id);
            list.add(demo);
        }
        return list;
    }
}
