package org.sha.ursip.service;

import org.sha.ursip.dao.ArticleLinkDAO;
import org.sha.ursip.dao.ArticlesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CountNews {
    @Autowired
    ArticleLinkDAO articleLinkDAO;
    @Autowired
    ArticlesDAO articlesDAO;

    public List<WriteString> countNewsList(int Id) {
        ArrayList<WriteString> list = new ArrayList<>();
        for (int j = 0; j < 11; j++) {
            if(articlesDAO.list().get(j).getTypeid()==Id) {
                WriteString writeString = new WriteString();
                writeString.setName(articlesDAO.list().get(j).getName());
                int count = 0;
                int count2 = 0;
                for (int k = 0; k < 11; k++) {
                    if (articlesDAO.list().get(k).getTypeid()==4) {
                        for (int i=0; i < 4; i++) {
                            if(articlesDAO.list().
                                    get(j).getId()==articleLinkDAO.list().get(i).getArticle1Id())
                                if(articlesDAO.list().
                                        get(k).getId()==articleLinkDAO.list().get(i).getArticle2Id())
                                    count++;
                        }
                    }
                }
                for (int k = 0; k < 11; k++) {
                    if (articlesDAO.list().get(k).getTypeid()==5) {
                        for (int i=0; i < 4; i++) {
                            if(articlesDAO.list().
                                    get(j).getId()==articleLinkDAO.list().get(i).getArticle1Id())
                                if(articlesDAO.list().
                                        get(k).getId()==articleLinkDAO.list().get(i).getArticle2Id())
                                    count2++;
                        }
                    }
                }
                writeString.setOfficialText(count);
                writeString.setEngText(count2);
                list.add(writeString);

            }
        }
        return list;
    }
}
