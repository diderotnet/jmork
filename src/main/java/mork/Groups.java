package mork;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {

	private List<Group> groups = new LinkedList<Group>();

	public Groups(String content) {
		content = StringUtils.removeCommentLines(content);
		content = StringUtils.removeNewlines(content);
		Pattern pattern = Pattern
				.compile("@\\$\\$\\{([0-9A-F]*)\\{@(.*)@\\$\\$\\}(\\1)\\}@");
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			String transactionId1 = matcher.group(1);
			String transactionContent = matcher.group(2);
			// String transactionId2 = matcher.group(3);
			groups.add(new Group(transactionId1, transactionContent));
		}
	}

	public int countGroups() {
		return groups.size();
	}

	public Group getGroup(int i) {
		return groups.get(i);
	}

}
