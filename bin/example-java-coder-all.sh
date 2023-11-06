config_path=$(pwd)/config.properties
echo $config_path
sh ./sparrow-java-coder.sh -mi com.sparrow.article.po.ArticleDetail -config=$config_path
sh ./sparrow-java-coder.sh -mi com.sparrow.cms.po.Album -config=$config_path
sh ./sparrow-java-coder.sh -mi com.sparrow.cms.po.FriendLink -config=$config_path
sh ./sparrow-java-coder.sh -mi com.sparrow.cms.po.Menu -config=$config_path
sh ./sparrow-java-coder.sh -mi com.sparrow.cms.po.Picture -config=$config_path
sh ./sparrow-java-coder.sh -mi com.sparrow.tag.po.Tag -config=$config_path
sh ./sparrow-java-coder.sh -mi com.sparrow.tag.po.Category -config=$config_path
sh ./sparrow-java-coder.sh -mi com.sparrow.passport.po.User -config=$config_path
sh ./sparrow-java-coder.sh -mi com.sparrow.interact.po.Comment -config=$config_path
sh ./sparrow-java-coder.sh -mi com.sparrow.interact.po.UserBehavior -config=$config_path
sh ./sparrow-java-coder.sh -mi com.sparrow.interact.po.ReplyComment -config=$config_path



